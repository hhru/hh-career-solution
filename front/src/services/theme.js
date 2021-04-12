import { createMuiTheme } from '@material-ui/core/styles';

const theme = createMuiTheme({
  palette: {
    secondary: {
      main: 'rgb(248, 92, 80)',
    },
    background: {
      default: '#fff',
    },
  },
  typography: {
    fontFamily: ["Helvetica", "Roboto", "Arial", "sans-serif"],
  }
});

export default theme;
