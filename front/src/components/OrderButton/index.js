import React from "react";
import { useHistory } from 'react-router';

import { Button } from "@material-ui/core";

const OrderButton = () => {
  const history = useHistory();
  const handleButton = () => {
    history.push("/request-form");
  }

  return (
    <Button variant="contained" color="secondary" size="large" onClick={handleButton}>
      Построить карьеру
    </Button>
  );
}

export default OrderButton;
