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
          rehypePlugins: [katex, { strict: false }],
          sidebarPath: require.resolve('./sidebars.js'),
          editUrl: 'https://github.com/Yue-plus/JVTC.Yue.Zone/tree/main/',
        },
        blog: {
          remarkPlugins: [math],
          rehypePlugins: [katex, { strict: false }],
          showReadingTime: true,
          editUrl: 'https://github.com/Yue-plus/JVTC.Yue.Zone/tree/main/',
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
        {type: 'doc', docId: '编程/Java/入门', position: 'left', label: '编程'},
        {type: 'doc', docId: '竞赛/蓝桥杯/README', position: 'left', label: '竞赛'},
        {type: 'doc', docId: '作业/高数D-李辉贤/复习题2022-2023', position: 'left', label: '作业'},
        // {type: 'doc', docId: '生存指南/前言', position: 'left', label: '《生存指南》'},
        {
          type: 'dropdown',
          label: '英语',
          position: 'left',
          items: [
            { type: 'doc', docId: '英语/通用英语B2题库/词汇配对', label: '通用英语题库' },
            { type: 'doc', docId: '作业/实用英语轻松GET/第一章测试', label: '实用英语轻松GET'},
          ],
        },
        {
          type: 'dropdown',
          label: '高等数学',
          positionL: 'left',
          items: [
            { type: 'doc', docId: '作业/高数D-李辉贤/复习题2022-2023', label: '高数D - 作业' },
            { href: 'https://math.note.yue.zone/docs/高等数学/导数与微分/函数的求导法则', label: 'MathNote - 高等数学' },
            { href: 'https://www.bilibili.com/video/BV1qW411N7FU/', label: '3Blue1Brown - 微积分的本质' },
          ],
        },
        {to: '/blog', label: '博客', position: 'left'},
        {href: 'https://net.note.yue.zone/', label: 'NetNote', position: 'right'},
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
      additionalLanguages: ['powershell', 'java', 'bash', 'csharp'],
    },
  }),

  plugins: [
    ['@docusaurus/plugin-pwa', {
      debug: true,
        offlineModeActivationStrategies: [
          'appInstalled',
          'standalone',
          'queryString',
        ],
        pwaHead: [
          {
            tagName: 'link',
            rel: 'icon',
            href: '/img/icons-512.png',
          },
          {
            tagName: 'link',
            rel: 'manifest',
            href: '/manifest.json', // 你的 PWA Manifest
          },
          {
            tagName: 'meta',
            name: 'theme-color',
            content: 'rgb(37, 194, 160)',
          },
        ],
    }],
  ],
};

module.exports = config;
