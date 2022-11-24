// @ts-nocheck
// Note: type annotations allow type checking and IDEs autocompletion

const math = require('remark-math');
const katex = require('rehype-katex');
const lightCodeTheme = require('prism-react-renderer/themes/github');
const darkCodeTheme = require('prism-react-renderer/themes/dracula');

/** @type {import('@docusaurus/types').Config} */
const config = {
  title: '悦域九职',
  tagline: 'JTVC.Yue.Zone',
  url: 'https://JVTC.Yue.Zone/',
  baseUrl: '/',
  onBrokenLinks: 'throw',
  onBrokenMarkdownLinks: 'warn',
  favicon: 'img/favicon.ico',

  organizationName: 'Yue-plus',
  projectName: 'JVTC.Yue.Zone',

  i18n: {defaultLocale: 'zh-Hans', locales: ['zh-Hans']},

  presets: [
    [
      'classic',
      /** @type {import('@docusaurus/preset-classic').Options} */
      ({
        docs: {
          remarkPlugins: [math],
          rehypePlugins: [katex],
          sidebarPath: require.resolve('./sidebars.js'),
          editUrl: 'https://github.com/Yue-plus/JVTC.Yue.Zone/tree/main/docs/',
        },
        blog: {
          showReadingTime: true,
          editUrl: 'https://github.com/Yue-plus/JVTC.Yue.Zone/tree/main/blog/',
        },
        theme: {customCss: require.resolve('./src/css/custom.css')},
      }),
    ],
  ],

  stylesheets: [
    {
      href: 'https://cdn.jsdelivr.net/npm/katex@0.13.24/dist/katex.min.css',
      type: 'text/css',
      integrity: 'sha384-odtC+0UGzzFL/6PNoE8rX/SPcQDXBJ+uRepguP4QkPCm2LBxH3FA3y+fKSiJ+AmM',
      crossorigin: 'anonymous',
    },
  ],

  themeConfig:
  /** @type {import('@docusaurus/preset-classic').ThemeConfig} */ ({
    tableOfContents: {minHeadingLevel: 2, maxHeadingLevel: 6},
    navbar: {
      title: '悦域九职',
      logo: {alt: '软件2201班班徽', src: 'img/班徽.svg'},
      items: [
        {type: 'doc', docId: '首页/欢迎', position: 'left', label: '欢迎'},
        {type: 'doc', docId: '编程/README', position: 'left', label: '编程'},
        {
          type: 'dropdown',
          label: '竞赛',
          position: 'left',
          items: [
            {type: 'doc', label: '蓝桥杯', docId: '竞赛/蓝桥杯'},
            {type: 'doc', label: '金砖赛', docId: '竞赛/金砖赛'},
            {type: 'doc', label: '信息素养', docId: '竞赛/信息素养'},
          ]
        },
        {
          type: 'dropdown',
          label: '作业',
          position: 'left',
          items: [
            {type: 'doc', label: '综合练习题', docId: '作业/综合练习题'},
            {type: 'doc', label: '每周任务', docId: '作业/每周任务'},
            {type: 'doc', label: '网页设计', docId: '作业/网页设计'},
            {type: 'doc', label: '程序设计基础C', docId: '作业/程序设计基础C'},
          ]
        },
        // {type: 'doc', docId: '生存指南/前言', position: 'left', label: '《生存指南》'},
        {to: '/blog', label: '博客', position: 'left'},
        {href: 'https://note.yueplus.ink/', label: 'NetNote', position: 'right'},
        {href: 'https://github.com/Yue-plus/JVTC.Yue.Zone', label: 'GitHub', position: 'right'},
      ],
    },
    footer: {
      style: 'dark',
      // links: [
      //   {
      //     title: 'Docs',
      //     items: [
      //       {
      //         label: 'Tutorial',
      //         to: '/docs/intro',
      //       },
      //     ],
      //   },
      //   {
      //     title: 'Community',
      //     items: [
      //       {
      //         label: 'Stack Overflow',
      //         href: 'https://stackoverflow.com/questions/tagged/docusaurus',
      //       },
      //       {
      //         label: 'Discord',
      //         href: 'https://discordapp.com/invite/docusaurus',
      //       },
      //       {
      //         label: 'Twitter',
      //         href: 'https://twitter.com/docusaurus',
      //       },
      //     ],
      //   },
      //   {
      //     title: 'More',
      //     items: [
      //       {
      //         label: 'Blog',
      //         to: '/blog',
      //       },
      //       {
      //         label: 'GitHub',
      //         href: 'https://github.com/facebook/docusaurus',
      //       },
      //     ],
      //   },
      // ],
      copyright: `Copyright © ${new Date().getFullYear()} YueZone, Inc. |
<a target="_blank" href="https://beian.miit.gov.cn/">赣ICP备19008355号</a> | 此网站使用
<a target="_blank" href="https://docusaurus.io/zh-CN/">Docusaurus</a> 构建。`,
    },
    prism: {
      theme: lightCodeTheme,
      darkTheme: darkCodeTheme,
    },
  }),
};

module.exports = config;
