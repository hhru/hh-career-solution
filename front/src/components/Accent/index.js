import { makeStyles } from '@material-ui/core';
import theme from './../../services/theme';

const useStyles = makeStyles({
  accent: {
    color: theme.palette.secondary.main,
  },
});

const Accent = ({ children }) => {
  const classes = useStyles();
  return (
    <span className={classes.accent}>
      {children}
    </span>
  );
}

export default Accent;
