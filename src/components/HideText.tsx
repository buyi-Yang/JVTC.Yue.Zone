import React from "react";
import { useState } from "react";

export default function HideText({ text }) {
  const [show, setShow] = useState(false)

  return <span
      style={{color: show ? "white" : "black", backgroundColor: "black", padding: "0 8px"}}
      onMouseEnter={() => setShow(true)}
      onMouseLeave={() => setShow(false)}
  >{text}</span>
}