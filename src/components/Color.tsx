import React from "react";

interface ColorProps {
  value: string,
  name: string | null | undefined,
}

export default function Color({value, name}: ColorProps) {
  return (
    <div style={{
      width: 120,
      height: 120,
      lineHeight: "120px",
      textAlign: "center",
      display: "inline-block",
      backgroundColor: value,
    }}>
      <span style={{backgroundColor: "RGBA(128, 128, 128, .8)"}}>{name ?? value.toUpperCase()}</span>
    </div>
  )
}