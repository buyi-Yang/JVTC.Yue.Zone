# Rocket

:::info
Rocket 是使用 [Rust] 语言编写的 Web 框架。
如果你愿意，你可以把 Rocket 想象成一个更灵活、更友好的
[Rails](https://rubyonrails.org/)、
[Flask](/docs/开发/框架/Flask/)、
[Bottle](https://bottlepy.org/docs/dev/index.html) 和
[Yesod](https://www.yesodweb.com/) 混合体。
我们更愿意将 Rocket 视为新事物。
Rocket 旨在快速、简单和灵活，同时尽可能提供有保证的安全性。
重要的是，Rocket 还旨在变得有趣，它通过确保你编写尽可能少的代码来完成任务来实现这一点。

[官方网站](https://rocket.rs/)
| [官方文档](https://rocket.rs/v0.5-rc/guide/getting-started/#getting-started)
| [API 文档](https://api.rocket.rs/v0.5-rc/rocket/)
| [中文文档](https://villezuo.gitee.io/rocketdoc/)
:::

## 响应

参考：[Responder in rocket::response - Rust](https://api.rocket.rs/v0.5-rc/rocket/response/trait.Responder.html)

```rust
// `T` 必须实现 `Responder`。
#[get("/")]
fn index() -> T { /* ... */ }
```

### 状态码

```rust title="src/main.rs"
#[macro_use]
extern crate rocket;

use rocket::http::Status;
use rocket::response::status::Custom;

#[get("/")]
fn index() -> Custom<&'static str> {
    Custom(Status::Ok, "Hello Rocket!")
}

#[launch]
fn rocket() -> _ {
    rocket::build().mount("/", routes![index])
}
```

### 自定义 Header

参考：[Custom Responders](https://rocket.rs/v0.5-rc/guide/responses/#custom-responders)

```rust
#[macro_use]
extern crate rocket;

mod structs;
mod routes;

use rocket::http::{ContentType, Header};
use rocket::response::Responder;


#[derive(Responder)]
#[response(status = 202, content_type = "json")]
struct IndexResponder {
    inner: String,
    headers: ContentType,
    more: Header<'static>,
}


#[get("/")]
fn index() -> IndexResponder {
    IndexResponder {
        inner: "abc".parse().unwrap(),
        headers: ContentType::Text,
        more: Header::new(
            "X-Authlib-Injector-API-Location", 
            // heighline
            "https://skin.mc.yue.zone/api/yggdrasil",
        ),
    }
}


#[launch]
fn rocket() -> _ {
    rocket::build().mount("/", routes![index])
}
```

### JSON

参考：[rocket::serde::json - Rust](https://docs.rs/rocket/0.5.0-rc.1/rocket/serde/json/index.html)
| [Serde](https://serde.rs/)

该模块仅在启用 `json` 特性时可用。
编辑 `Cargo.toml` 文件启用该特性：

```toml title="Cargo.toml"
[dependencies.rocket]
version = "=0.5.0-rc.3"
# highlight-next-line
features = ["json"]
```

```rust title="src/main.rs"
#[macro_use]
extern crate rocket;

use rocket::serde::{Serialize, json::Json};

#[derive(Serialize)]
#[serde(crate = "rocket::serde", rename_all = "camelCase")]
struct IndexMetaLinks {
    homepage: String,
    register: String,
}

#[derive(Serialize)]
#[serde(crate = "rocket::serde", rename_all = "camelCase")]
struct IndexMeta {
    server_name: String,
    implementation_name: String,
    implementation_version: String,
    links: IndexMetaLinks,
}

#[derive(Serialize)]
#[serde(crate = "rocket::serde", rename_all = "camelCase")]
struct Index {
    meta: IndexMeta,
    skin_domains: Vec<String>,
    signature_publickey: String,
}

#[get("/")]
fn index() -> Json<Index> {
    Json(Index {
        meta: IndexMeta {
            server_name: String::from("YueZoneYggdrasil"),
            implementation_name: String::from("YueZone Minecraft Skin Site"),
            implementation_version: String::from("0.0.0"),
            links: IndexMetaLinks {
                homepage: String::from("http://localhost:8000/"),
                register: String::from("http://localhost:8000/register"),
            },
        },
        skin_domains: vec![
            String::from("localhost"),
            String::from("yue.zone"),
        ],
        signature_publickey: String::from("-----BEGIN PUBLIC KEY-----"),
    })
}

#[launch]
fn rocket() -> _ {
    rocket::build().mount("/", routes![index])
}
```

```json title="HTTP GET /"
{
    "meta": {
        "serverName": "YueZoneYggdrasil",
        "implementationName": "YueZone Minecraft Skin Site",
        "implementationVersion": "0.0.0",
        "links": {
            "homepage": "http://localhost:8000/",
            "register": "http://localhost:8000/register"
        }
    },
    "skinDomains": [
        "localhost",
        "yue.zone"
    ],
    "signaturePublicKey": "-----BEGIN PUBLIC KEY-----"
}
```


[Rust]: ../../00-语言/Rust/README.md
