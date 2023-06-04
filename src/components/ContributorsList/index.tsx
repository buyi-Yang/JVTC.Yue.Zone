import React from "react";
import style from './style.module.css';

interface ContributorProps {
  name: string,
  href: string,
  avatar?: string,
}

function Contributor({name, href, avatar}: ContributorProps) {
  return (
    <a className={style.headLink} target="_blank" href={href}>
      <img className={style.headImg} src={avatar ?? `/contributors/${name}.png`} alt={name} />
      <br/>
      {name}
    </a>
  )
}

export default function ContributorsList(){
  return (
    <div className="container" style={{paddingTop: 16}}>
      <h1>贡献者</h1>
      <div className="row">
        <div>
          <Contributor name="Yue_plus" href="https://github.com/Yue-plus" />
          <Contributor name="buyi-Yang" href="https://github.com/buyi-Yang"/>
          <Contributor name="kejue-sususu" href="https://github.com/kejue-sususu"/>
          <Contributor name="liao-666" href="https://github.com/liao-666"/>
        </div>
      </div>
    </div>
  )
}