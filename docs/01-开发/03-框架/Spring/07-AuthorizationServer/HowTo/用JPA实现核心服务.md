# 用 JPA 实现核心服务

**此页面正在施工！请谨慎参考。**

> 参考：[官方文档](https://docs.spring.io/spring-authorization-server/docs/current/reference/html/guides/how-to-jpa.html)
> | [中文文档](https://springdoc.cn/spring-authorization-server/guides/how-to-jpa.html)

## 创建 JPA 实体

### 客户端实体

用来持久化从
[RegisteredClient](https://springdoc.cn/spring-authorization-server/core-model-components.html#registered-client)
`domain` 对象映射的信息。

```kotlin title="src/main/kotlin/zone/yue/core/user/UserEntity.kt"
package zone.yue.core.authorization

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant


@Entity
@Table(name = "`client`")
class ClientEntity(
    @Id val id: String,
    val clientId: String,
    val clientIdIssuedAt: Instant,
    val clientSecret: String,
    val clientSecretExpiresAt: Instant,
    val clientName: String,

    @Column(length = 1000) val clientAuthenticationMethods: String,
    @Column(length = 1000) val authorizationGrantTypes: String,
    @Column(length = 1000) val redirectUris: String,
    @Column(length = 1000) val scopes: String,
    @Column(length = 2000) val clientSettings: String,
    @Column(length = 2000) val tokenSettings: String,
)
```

### 授权许可实体

用来保存从
[OAuth2Authorization](https://springdoc.cn/spring-authorization-server/core-model-components.html#oauth2-authorization)
`domain` 对象映射的信息。

```kotlin title="src/main/kotlin/zone/yue/core/user/AuthorizationEntity.kt"
package zone.yue.core.authorization

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "`authorization`")
class AuthorizationEntity (
    @Id @Column val id: String,
    val registeredClientId: String,
    val principalName: String,
    val authorizationGrantType: String,

    @Column(length = 1000) val authorizedScopes: String,
    @Column(length = 4000) val attributes: String,
    @Column(length = 500) val state: String,

    @Column(length = 4000)
    val authorizationCodeValue: String,
    val authorizationCodeIssuedAt: Instant,
    val authorizationCodeExpiresAt: Instant,
    val authorizationCodeMetadata: String,

    @Column(length = 4000)
    val accessTokenValue: String,
    val accessTokenIssuedAt: Instant,
    val accessTokenExpiresAt: Instant,

    @Column(length = 2000)
    val accessTokenMetadata: String,
    val accessTokenType: String,

    @Column(length = 1000) val accessTokenScopes: String,

    @Column(length = 4000)
    val refreshTokenValue: String,
    val refreshTokenIssuedAt: Instant,
    val refreshTokenExpiresAt: Instant,

    @Column(length = 2000) val refreshTokenMetadata: String,

    @Column(length = 4000)
    val oidcIdTokenValue: String,
    val oidcIdTokenIssuedAt: Instant,
    val oidcIdTokenExpiresAt: Instant,

    @Column(length = 2000) val oidcIdTokenMetadata: String,
    @Column(length = 2000) val oidcIdTokenClaims: String,
)
```

### 授权许可实体

用来保存从
[OAuth2AuthorizationConsent](https://springdoc.cn/spring-authorization-server/core-model-components.html#oauth2-authorization-consent)
`domain` 对象映射的信息。

```kotlin title="src/main/kotlin/zone/yue/core/user/AuthorizationConsentEntity.kt"
package zone.yue.core.authorization

import jakarta.persistence.*
import java.io.Serializable
import java.util.*

@Entity
@Table(name = "`authorization_consent`")
@IdClass(AuthorizationConsentEntity.AuthorizationConsentId::class)
class AuthorizationConsentEntity (
    @Id val registeredClientId: String,
    @Id val principalName: String,
    @Column(length = 1000) val authorities: String,
) {
    class AuthorizationConsentId : Serializable {
        private val registeredClientId: String? = null
        private val principalName: String? = null

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other == null || javaClass != other.javaClass) return false
            val that = other as AuthorizationConsentId
            return registeredClientId == that.registeredClientId && principalName == that.principalName
        }

        override fun hashCode(): Int {
            return Objects.hash(registeredClientId, principalName)
        }
    }
}
```

## 创建 Spring Data Repository

### Client Repository

能够通过 `id` 和 `clientId` 字段找到一个 [ClientEntity](#客户端实体)。

```kotlin title="src/main/kotlin/zone/yue/core/authorization/ClientRepository.kt"
package zone.yue.core.authorization

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClientRepository : JpaRepository<ClientEntity, String> {
    fun findByClientId(clientId: String): ClientEntity
}
```

### Authorization Repository

能够通过 `id` 字段以及 `state`、`authorizationCodeValue`、`accessTokenValue` 和 `refreshTokenValue` *token* 字段找到一个 [AuthorizationEntity](#授权许可实体)，它还允许查询 token 字段的组合。

```kotlin title="src/main/kotlin/zone/yue/core/authorization/AuthorizationRepository.kt"
package zone.yue.core.authorization

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AuthorizationRepository : JpaRepository<AuthorizationEntity, String> {
    fun findByState(state: String): AuthorizationEntity
    fun findByAuthorizationCodeValue(authorizationCode: String): AuthorizationEntity
    fun findByAccessTokenValue(accessToken: String): AuthorizationEntity
    fun findByRefreshTokenValue(refreshToken: String?): AuthorizationEntity

    @Query(
        "select a from AuthorizationEntity a where a.state = :token" +
                " or a.authorizationCodeValue = :token" +
                " or a.accessTokenValue = :token" +
                " or a.refreshTokenValue = :token"
    )
    fun findByStateOrAuthorizationCodeValueOrAccessTokenValueOrRefreshTokenValue(@Param("token") token: String?)
            : AuthorizationEntity
}
```

### Authorization Consent Repository

能够通过构成复合主键的 `registeredClientId` 和 `principalName` 字段找到并删除一个 [AuthorizationConsentEntity](#授权许可实体)。

```kotlin title="src/main/kotlin/zone/yue/core/authorization/AuthorizationConsentRepository.kt"
package zone.yue.core.authorization

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorizationConsentRepository :
    JpaRepository<AuthorizationConsentEntity, AuthorizationConsentEntity.AuthorizationConsentId> {
    fun findByRegisteredClientIdAndPrincipalName(
        registeredClientId: String,
        principalName: String,
    ): AuthorizationConsentEntity

    fun deleteByRegisteredClientIdAndPrincipalName(registeredClientId: String, principalName: String)
}
```

## 实现核心服务

### Registered Client Repository

### Authorization Service

### Authorization Consent Service
