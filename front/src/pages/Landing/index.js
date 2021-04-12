import React from 'react';
import LandingGoalsSlide from './../../components/LandingGoalsSlide';
import LandingHowItHelpsSlide from './../../components/LandingHowItHelpsSlide';
import LandingHowItWorksSlide from './../../components/LandingHowItWorksSlide';
import LandingFaqSlide from './../../components/LandingFaqSlide';
import LandingWhyNeedSessionSlide from './../../components/LandingWhyNeedSessionSlide';
import LandingPeoplesSlide from './../../components/LandingPeoplesSlide';

const Landing = () => {
  return (
    <React.Fragment>
      <LandingGoalsSlide />
      <LandingHowItHelpsSlide />
      <LandingWhyNeedSessionSlide />
      <LandingHowItWorksSlide />
      <LandingPeoplesSlide />
      <LandingFaqSlide />
    </React.Fragment>
  );
}

export default Landing;
