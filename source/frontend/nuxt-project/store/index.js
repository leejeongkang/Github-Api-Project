import {
  fetchRepos,
  fetchBranchList,
  fetchPrCnt,
  fetchCommitCnt,
  fetchBranchCnt,
  fetchAuthorCnt,
  fetchCommitCntByUser,
  fetchPrCntByUser,
  fetchCommitCntByDate,
  fetchPrCntByDate,
} from '@/api'

export const FETCH_REPOS = 'FETCH_REPOS'
export const FETCH_BRANCH_LIST = 'FETCH_BRANCH_LIST'
export const FETCH_COMMIT_CNT = 'FETCH_COMMIT_CNT'
export const FETCH_PR_CNT = 'FETCH_PR_CNT'
export const FETCH_BRANCH_CNT = 'FETCH_BRANCH_CNT'
export const FETCH_AUTHOR_CNT = 'FETCH_AUTHOR_CNT'
export const FETCH_COMMIT_CNT_BY_USER = 'FETCH_COMMIT_CNT_BY_USER'
export const FETCH_PR_CNT_BY_USER = 'FETCH_PR_CNT_BY_USER'
export const FETCH_COMMIT_CNT_BY_DATE = 'FETCH_COMMIT_CNT_BY_DATE'
export const FETCH_PR_CNT_BY_DATE = 'FETCH_PR_CNT_BY_DATE'

export const state = () => ({
  repos: [],
  repo: null,
  branchList: [],
  commitCnt: null,
  authorCnt: null,
  branchCnt: null,
  prCnt: null,
  commitCntByUser: null,
  prCntByUser: null,
  commitCntByDate: null,
  prCntBYDate: null
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
  async [FETCH_REPOS]({ commit }) {
    const { data } = await fetchRepos()
    commit('setRepos', data)
  },
  async [FETCH_BRANCH_LIST]({ commit }, repo) {
    const { data } = await fetchBranchList(repo)
    commit('setBranchList', data)
  },
  async [FETCH_COMMIT_CNT]({ commit }, repo) {
    const { data } = await fetchCommitCnt(repo)
    commit('setCommitCnt', data)
  },
  async [FETCH_BRANCH_CNT]({ commit }, repo) {
    const { data } = await fetchBranchCnt(repo)
    commit('setBranchCnt', data)
  },
  async [FETCH_PR_CNT]({ commit }, repo) {
    const { data } = await fetchPrCnt(repo)
    commit('setPrCnt', data)
  },
  async [FETCH_AUTHOR_CNT]({ commit }, repo) {
    const { data } = await fetchAuthorCnt(repo)
    commit('setAuthorCnt', data)
  },
  async [FETCH_COMMIT_CNT_BY_USER]({ commit }, repo, user){
    const { data } = await fetchCommitCntByUser(repo, user)
    commit('setCommitCntByUser', data)
  },
  async [FETCH_PR_CNT_BY_USER]({ commit }, repo, user){
    const { data } = await fetchPrCntByUser(repo, user)
    commit('setPrCntByUser', data)
  },
  async [FETCH_COMMIT_CNT_BY_DATE]({ commit }, repo, datePick){
    const { data } = await fetchCommitCntByDate(repo, datePick)
    commit('setCommitCntByDate', data)
  },
  async [FETCH_PR_CNT_BY_DATE]({ commit }, repo, datePick){
    const { data } = await fetchPrCntByDate(repo, datePick)
    commit('setPrCntByDate', data)
  },
};
