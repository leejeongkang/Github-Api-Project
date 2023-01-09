import axios from "axios";

export const state = () => ({
  repos: [],
  branchList: [],
  commitCnt: [],
  authorCnt: null,
  branchCnt: null,
  prCnt: null,
  commitCntByUser: [],
  prCntByUser: [],
  commitCntByDate: [],
  prCntByDate: null,
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
  getCommitCntByUser({ commit }, repo) {
    return axios.get(`http://localhost:80/repo-api/${repo}/commit-cnt/user`).then((res) => {
      commit('setCommitCntByUser', res.data)
    })
  },
  getCommitCntByUserPage({ commit }, {repo, page}) {
    return axios.get(`http://localhost:80/repo-api/${repo}/commit-cnt/user`, {params: {page: page}}).then((res) =>{
      commit('setCommitCntByUser', res.data)
    })
  },
  getPrCntByUser({ commit }, repo) {
    return axios.get(`http://localhost:80/repo-api/${repo}/pr-cnt/user`).then((res) => {
      commit('setPrCntByUser', res.data)
    })
  },
  getPrCntByUserPage({ commit }, {repo, page}) {
    return axios.get(`http://localhost:80/repo-api/${repo}/pr-cnt/user`, {params: {page: page}}).then((res) => {
      commit('setPrCntByUser', res.data)
    })
  },
  getCommitCntByDate({ commit }, { repo, since, until }) {
    return axios.get(`http://localhost:80/repo-api/${repo}/commit-cnt/date`, {params: {since: since, until: until}}).then((res) => {
      commit('setCommitCntByDate', res.data)
    })
  },
  getPrCntByDate({ commit }, { repo, dateValue }) {
    return axios.get(`http://localhost:80/repo-api/${repo}/pr-cnt/${dateValue}`).then((res) => {
      commit('setPrCntByDate', res.data)
    })
  },
};
