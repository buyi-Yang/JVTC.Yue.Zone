import React from "react";

interface ColorProps {
  color: string,
  name: string | null | undefined,
}

export default function Color({color, name}: ColorProps) {
  return (
    <div style={{
      width: 120,
      height: 120,
      lineHeight: "120px",
      textAlign: "center",
      display: "inline-block",
      backgroundColor: color,
    }}>
      <span style={{backgroundColor: "RGBA(128, 128, 128, .8)"}}>{name ?? color.toUpperCase()}</span>
    </div>
  )
}