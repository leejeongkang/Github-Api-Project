import axios from "axios";

export const state = () => ({
  repos: [],
  branchList: [],
  commitCnt: null,
  authorCnt: null,
  branchCnt: null,
  prCnt: null,
  commitCntByUser: null,
  prCntByUser: null,
  commitCntByDate: null,
  prCntByDate: null
});

export const getters = {

};

export const mutations = {
  setRepos(state, repos) {
    state.repos = repos.data
  },
  setBranchList(state, branchList) {
    state.branchList = branchList.data
  },
  setCommitCnt(state, commitCnt) {
    state.commitCnt = commitCnt.data
  },
  setBranchCnt(state, branchCnt) {
    state.branchCnt = branchCnt.data
  },
  setPrCnt(state, prCnt) {
    state.prCnt = prCnt.data
  },
  setAuthorCnt(state, authorCnt) {
    state.authorCnt = authorCnt.data
  },
  setCommitCntByUser(state, commitCntByUser) {
    state.commitCntByUser = commitCntByUser.data
  },
  setPrCntByUser(state, prCntByUser) {
    state.prCntByUser = prCntByUser.data
  },
  setCommitCntByDate(state, commitCntByDate) {
    state.commitCntByDate = commitCntByDate.data
  },
  setPrCntByDate(state, prCntByDate) {
    state.prCntByDate = prCntByDate.data
  },
};

export const actions = {
  getRepos({ commit }) {
    return axios.get('http://localhost:80/repo-api/repos').then((res) => {
      commit('setRepos', res.data)
    })
  },
  getBranchList({ commit }, repo){
    return axios.get(`http://localhost:80/repo-api/branch-list/${repo}`).then((res) => {
      commit('setBranchList', res.data)
    })
  },
  getCommitCnt({ commit }, repo){
    return axios.get(`http://localhost:80/repo-api/${repo}/commit-cnt`).then((res) => {
      commit('setCommitCnt', res.data)
    })
  },
  getBranchCnt({ commit }, repo){
    return axios.get(`http://localhost:80/repo-api/${repo}/branch-cnt`).then((res) => {
      commit('setBranchCnt', res.data)
    })
  },
  getPrCnt({ commit }, repo){
    return axios.get(`http://localhost:80/repo-api/${repo}/pr-cnt`).then((res) => {
      commit('setPrCnt', res.data)
    })
  },
  getUserCnt({ commit }, repo){
    return axios.get(`http://localhost:80/repo-api/${repo}/user-cnt`).then((res) => {
      commit('setAuthorCnt', res.data)
    })
  },
  getCommitCntByUser({ commit }, { repo, user }) {
    return axios.get(`http://localhost:80/repo-api/${repo}/commit-cnt/${user}`).then((res) => {
      commit('setCommitCntByUser', res.data)
    })
  },
  getPrCntByUser({ commit }, { repo, user }) {
    return axios.get(`http://localhost:80/repo-api/${repo}/pr-cnt/${user}`).then((res) => {
      commit('setPrCntByUser', res.data)
    })
  },
  getCommitCntByDate({ commit }, { repo, datePick }) {
    return axios.get(`http://localhost:80/repo-api/${repo}/commit-cnt/${datePick}`).then((res) => {
      commit('setCommitCntByDate', res.data)
    })
  },
  getPrCntByDate({ commit }, { repo, datePick }) {
    return axios.get(`http://localhost:80/repo-api/${repo}/commit-cnt/${datePick}`).then((res) => {
      commit('setPrCntByDate', res.data)
    })
  },
};
