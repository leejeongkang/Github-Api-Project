import { fetchRepos } from '@/api'

export const FETCH_REPOS = 'FETCH_REPOS'

export const state = () => ({
  repos: []
});

export const getters = {

};

export const mutations = {
  setRepos(state, repos) {
    state.repos = repos.data
  }

};

export const actions = {
  async [FETCH_REPOS]({ commit }) {
    const { data } = await fetchRepos()
    commit('setRepos', data)
  }
};
