import React from "react";

export default function BorderCard({ children }) {
    return <div style={{ border: "1px solid black", padding: "12px 18px", margin: "12px 0" }}>
        { children }
    </div>
}