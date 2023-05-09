import React from "react";

export default function BorderCard({title, children}) {
    return <div style={{border: "1px solid black", padding: "12px 18px", margin: "12px 0"}}>
        {title ? <h4 style={{textAlign: "center"}}>{title}</h4> : null}
        {children}
    </div>
}