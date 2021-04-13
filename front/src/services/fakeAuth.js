const fakeAuth = {
  isAuthenticated: false,
  authenticate(cb) {
    this.isAuthenticated = true;
    setTimeout(cb, 300);
  },
  signout(cb) {
    this.isAuthenticated = false;
    setTimeout(cb, 300);
  },
};

export default fakeAuth;
