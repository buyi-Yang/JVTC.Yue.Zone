# JOSE

:::info
`spring-security-oauth2-jose.jar` 包中包含 Spring Security 对 JOSE（Javascript Object Signing and Encryption）框架的支持。
JOSE 框架旨在提供一种方法，在各方之间安全地转移 claim。
它是由一系列规范构建的。

- **JWT**: JSON Web Token
  + [<img src="http://jwt.io/img/logo-asset.svg" alt="JWT" style={{height: "48px", borderRadius: "24px"}} />](https://jwt.io/)
- **JWS**: JSON Web Signature
- **JWE**: JSON Web Encryption
- **JWK**: JSON Web Key

它包含以下顶级包。

- `org.springframework.security.oauth2.jwt`
- `org.springframework.security.oauth2.jose`
:::

## 教程

- [OAuth 2.0 资源服务器 JWT :: Spring Security Reference](https://springdoc.cn/spring-security/servlet/oauth2/resource-server/jwt.html)
- [JWS + JWK in a Spring Security OAuth2 Application | Baeldung](https://www.baeldung.com/spring-security-oauth2-jws-jwk)
- [JWT全面解读、详细使用步骤 - 简书](https://www.jianshu.com/p/d1644e281250)

## `JwtClaimsSet`



## JWT Login Sample

[JWT Login Sample](https://github.com/spring-projects/spring-security-samples/tree/main/servlet/spring-boot/java/jwt/login)
这个官方示例演示了如何在不使用单独的授权服务器的情况下接受 JWT。

当用户希望使用用户名和密码进行本地身份验证，然后使用 JWT 时，此方法在 REST API 中非常有用。

### 生成 RSA 密钥对

```bash
cd src/main/resources/application

# 在当前目录下生成 PKCS#8 格式的私钥
openssl genpkey -out app.key -algorithm RSA -pkeyopt rsa_keygen_bits:2048

# 使用私钥生成公钥
openssl rsa -in app.key -pubout -out app.pub
```

### 编辑配置文件

```yaml title="src/main/resources/application.yaml"
jwt:
  private-key: classpath:app.key
  public-key: classpath:app.pub
```

### 编写配置类

```kotlin
package zone.yue.core

import com.nimbusds.jose.jwk.JWK
import com.nimbusds.jose.jwk.JWKSet
import com.nimbusds.jose.jwk.RSAKey
import com.nimbusds.jose.jwk.source.ImmutableJWKSet
import com.nimbusds.jose.jwk.source.JWKSource
import com.nimbusds.jose.proc.SecurityContext
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler
import org.springframework.security.web.SecurityFilterChain
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey


@Configuration
@EnableWebSecurity
class SecurityConfiguration {
    @Value("\${jwt.private-key}")
    var key: RSAPrivateKey? = null

    @Value("\${jwt.public-key}")
    var pub: RSAPublicKey? = null

    @Bean
    fun jwtDecoder(): JwtDecoder = NimbusJwtDecoder.withPublicKey(pub).build()

    @Bean
    fun jwtEncoder(): JwtEncoder {
        val jwk: JWK = RSAKey.Builder(pub).privateKey(key).build()
        val jwkSet: JWKSource<SecurityContext> = ImmutableJWKSet(JWKSet(jwk))
        return NimbusJwtEncoder(jwkSet)
    }

    // TODO: 实现一个 UserDetailsService

    @Bean
    fun filterChain(http: HttpSecurity, encoder: JwtEncoder): SecurityFilterChain {
        http {
            csrf { disable() }

            authorizeRequests {
                authorize("/api/signup", permitAll)
                authorize("/api/login", permitAll)
                authorize(anyRequest, authenticated)
            }

            httpBasic {  }

            oauth2ResourceServer {
                jwt {  }
            }

            sessionManagement {
                sessionCreationPolicy = SessionCreationPolicy.STATELESS
            }

            exceptionHandling {
                authenticationEntryPoint = BearerTokenAuthenticationEntryPoint()
                accessDeniedHandler = BearerTokenAccessDeniedHandler()
            }
        }

        return http.build()
    }
}
```

### 编写控制器

```kotlin
package zone.yue.core

import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.stream.Collectors


@RestController
@RequestMapping("/api")
@CrossOrigin
class AccountRestController(val accountService: AccountService, val jwtEncoder: JwtEncoder) {
    @GetMapping("/hi")
    fun hi(authentication: Authentication): String = "Hello! ${authentication.name} !"

    @PostMapping("/token")
    fun token(authentication: Authentication): String {
        val now = Instant.now()
        val scope = authentication.authorities.stream()
            .map { obj: GrantedAuthority -> obj.authority }
            .collect(Collectors.joining(" "))
        val claims = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            // .expiresAt(now.plusSeconds(36000L))    // 10 小时后过期
            .expiresAt(now.plus(90, ChronoUnit.DAYS)) // 90 天后过期
            .subject(authentication.name)
            .claim("scope", scope)
            .build()

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).tokenValue
    }
}
```

### 获取令牌

```sh
curl -XPOST username:password@localhost:8080/api/token
```

### 使用令牌

```http
GET http://localhost:8080/api/info
Authorization: Bearer {{token}}
```