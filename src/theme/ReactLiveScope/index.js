import React from 'react';
import Color from '@site/src/components/Color';
import HideText from '@site/src/components/HideText';
import BorderCard from '@site/src/components/BorderCard';
import { ContributorsList, Contributor } from '@site/src/components/ContributorsList';

// Add react-live imports you need here
const ReactLiveScope = {
  React,
  ...React,
  Color,
  HideText,
  BorderCard,
  ContributorsList,
  Contributor,
};
export default ReactLiveScope;
