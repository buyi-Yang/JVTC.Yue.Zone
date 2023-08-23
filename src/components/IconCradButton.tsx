import React from "react";

export default function IconCardButton({icon, title, text, href}) {
    return <a href={href} style={{
        width: text.length > 20 ? 608 : 300,
        height: 128,
        padding: 8,
        margin: "0 8px 8px 0",
        backgroundColor: "rgba(160, 160, 160, .1)",
        borderRadius: 12,
        display: "flex",
        justifyContent: "space-around",
        alignItems: "center",
        userSelect: "none",
    }}>
        <img src={`/icons/${icon}`} alt={title} style={{
            height: "90%",
            minHeight: 100,
            maxWidth: 100,
            display: "inline-block",
        }}/>
        <div style={{width: text.length > 20 ? 484 : 184, paddingLeft: 8, display: "inline-block"}}>
            <h3 style={{marginBottom: 8}}>{title}</h3>
            <span>{text}</span>
        </div>
    </a>
}