import createPersistedState from "vuex-persistedstate";

export default ({store}) => {
  createPersistedState({
    key: 'iwdf',
    storage: window.sessionStorage
  })(store)
}
