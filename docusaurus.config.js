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
        {type: 'doc', docId: '开发/INDEX', position: 'left', label: '开发'},
        {type: 'doc', docId: '运行维护/INDEX', position: 'left', label: '运行维护'},
        {type: 'doc', docId: '信息安全/INDEX', position: 'left', label: '信息安全'},
        {type: 'doc', docId: '竞赛/全国职业院校技能大赛/GZ031-应用软件系统开发赛项', position: 'left', label: '竞赛'},
        {type: 'doc', docId: '专业课/INDEX',  position: 'left', label: '专业课'},
        {type: 'doc', docId: '公共课/README',  position: 'left', label: '公共课'},
        // {type: 'doc', docId: '生存指南/前言', position: 'left', label: '《生存指南》'},
        {to: '/blog', label: '博客', position: 'left'},
        {href: 'https://net.note.yue.zone/', label: 'NetNote', position: 'right'},
        {href: 'https://github.com/Yue-plus/JVTC.Yue.Zone', label: 'GitHub', position: 'right'},
      ],
    },
    algolia: {
      appId: 'EAJM875Q4F',
      apiKey: 'c39d0d2992b9e4c9363c4c3f28a4dbca',
      indexName: 'jvtc-yue',
      contextualSearch: true,

      // Optional: Specify domains where the navigation should occur through window.location instead on history.push. Useful when our Algolia config crawls multiple documentation sites and we want to navigate with window.location.href to them.
      externalUrlRegex: 'external\\.com|domain\\.com',

      // Optional: Replace parts of the item URLs from Algolia. Useful when using the same search index for multiple deployments using a different baseUrl. You can use regexp or string in the `from` param. For example: localhost:3000 vs myCompany.com/docs
      // replaceSearchResultPathname: {
      //   from: '/docs/', // or as RegExp: /\/docs\//
      //   to: '/docs/',
      // },

      // Optional: Algolia search parameters
      searchParameters: {},

      // Optional: path for search page that enabled by default (`false` to disable it)
      searchPagePath: 'search',

      //... other Algolia params
    },
    docs: {
      sidebar: {
        hideable: true,
        autoCollapseCategories: true,
      },
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
      additionalLanguages: ['powershell', 'java', 'kotlin', 'dart', 'bash', 'csharp', 'rust', 'yaml', 'toml', 'log', 'regex', 'http'],
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

  markdown: { mermaid: true },

  themes: ['@docusaurus/theme-mermaid', '@docusaurus/theme-live-codeblock'],
};

module.exports = config;
