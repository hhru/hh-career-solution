import { createMuiTheme } from "@material-ui/core/styles";

const theme = createMuiTheme({
  palette: {
    secondary: {
      main: "rgb(248, 92, 80)",
    },
    background: {
      default: "#fff",
    },
  },
  typography: {
    fontFamily: ["Helvetica", "Roboto", "Arial", "sans-serif"],
  },
  breakpoints: {
    values: {
      xs: 0,
      sm: 600,
      md: 960,
      lg: 1280,
      xl: 1920,
    },
  },
});

export default theme;
