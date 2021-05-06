import React from "react";

import LandingGoalsSlide from "src/components/LandingGoalsSlide";
import LandingHowItHelpsSlide from "src/components/LandingHowItHelpsSlide";
import LandingHowItWorksSlide from "src/components/LandingHowItWorksSlide";
import LandingFaqSlide from "src/components/LandingFaqSlide";
import LandingWhyNeedSessionSlide from "src/components/LandingWhyNeedSessionSlide";
import LandingPeoplesSlide from "src/components/LandingPeoplesSlide";

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
};

export default Landing;
