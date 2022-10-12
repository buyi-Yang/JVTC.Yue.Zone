import React from "react";
import style from './style.module.css';

function Contributor(props) {
  return (
    <a className={style.headLink} target="_blank" href={props.href}>
      <img className={style.headImg} src={props.imgSrc} alt={props.name} />
      <br/>
      {props.name}
    </a>
  )
}

export default function ContributorsList() {
  return (
    <div className="container" style={{paddingTop: 16}}>
      <h1>贡献者</h1>
      <div className="row">
        <div>
          <Contributor name="Yue_plus" href="https://github.com/Yue-plus" imgSrc="https://github.com/Yue-plus.png" />
        </div>
      </div>
    </div>
  )
}