export const state = () => ({
});

export const getters = {

};

export const mutations = {

};

export const actions = {
  getCsrfToken() {
    return this.$axios.get("/api/csrf-token");
  }
};
