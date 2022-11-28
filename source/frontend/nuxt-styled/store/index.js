export const state = () => ({
  _user: null
});

export const getters = {
  user(state) {
    return state._user;
  }
};

export const mutations = {
  setUser(state, data) {
    state._user = data;
  }
};

export const actions = {
  getCsrfToken() {
    return this.$axios.get("/api/csrf-token");
  }
};
