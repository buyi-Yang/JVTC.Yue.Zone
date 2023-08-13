import React from 'react';
import clsx from 'clsx';
import Link from '@docusaurus/Link';
import useDocusaurusContext from '@docusaurus/useDocusaurusContext';
import Layout from '@theme/Layout';
import { ContributorsList } from '@site/src/components/ContributorsList'
// import HomepageFeatures from '@site/src/components/HomepageFeatures';

import styles from './index.module.css';

function HomepageHeader() {
  const {siteConfig} = useDocusaurusContext();
  return (
    <header className={clsx('hero hero--primary', styles.heroBanner)}>
      <div className="container">
        <img src="/img/班徽.svg" width={320} height={320} />
        <h1 className="hero__title">{siteConfig.title}</h1>
        <p className="hero__subtitle">{siteConfig.tagline}</p>
        <div className={styles.buttons}>
          <Link className="button button--secondary button--lg" to="/docs/首页/欢迎">READ MORE +</Link>
        </div>
      </div>
    </header>
  );
}

export default function Home(): JSX.Element {
  const { siteConfig } = useDocusaurusContext();
  return (
      <Layout
          title={`首页`}
          description="悦域九职 - JVTC.Yue.Zone">
        <HomepageHeader />
        <main>
          <ContributorsList />
          {/*<HomepageFeatures />*/}
        </main>
      </Layout>
  );
}
