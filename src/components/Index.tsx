import React from "react";
import IconCardButton from "@site/src/components/IconCradButton";

// 方便复制：{icon: "", title: "", text: "", href: ""},
export type IndexItems = { icon: string, title: string, text: string, href: string }

export default function Index(items: Array<IndexItems>): React.JSX.Element {
    return <div className="row" style={{justifyContent: "center"}}>{
        items.map((item: IndexItems) => <IconCardButton {...item} />)
    }</div>
}
