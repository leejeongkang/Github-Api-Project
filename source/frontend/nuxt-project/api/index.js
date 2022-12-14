import axios from 'axios'

const instance = axios.create({
  baseURL: 'http://localhost:80/repo-api/'
})
instance.interceptors.request.use(
  (config) => {
    config.headers['Access-Control-Allow-Origin'] = '*';
    return config
  }
)
function fetchRepos() {
  return instance.get('repos')
}
function fetchBranchList(repo) {
  return instance.get(`branch-list/${repo}`, {repo})
}

function fetchCommitCnt(repo) {
  return instance.get(`${repo}/commit-cnt`, {repo})
}

function fetchAuthorCnt(repo) {
  return instance.get(`${repo}/user-cnt`, {repo})
}

function fetchPrCnt(repo) {
  return instance.get(`${repo}/pr-cnt`, {repo})
}

function fetchBranchCnt(repo) {
  return instance.get(`${repo}/branch-cnt`, {repo})
}

function fetchCommitCntByUser(repo, user){
  return instance.get(`${repo}/commit-cnt/${user}`, {repo, user})
}
function fetchPrCntByUser(repo, user){
  return instance.get(`${repo}/pr-cnt/${user}`, {repo, user})
}
function fetchCommitCntByDate(repo, datePick){
  return instance.get(`${repo}/commit-cnt/${datePick}`, {repo, datePick})
}
function fetchPrCntByDate(repo, datePick){
  return instance.get(`${repo}/pr-cnt/${datePick}`, {repo, datePick})
}
export { fetchRepos, fetchBranchList, fetchAuthorCnt, fetchBranchCnt, fetchCommitCnt, fetchPrCnt, fetchPrCntByDate,
          fetchCommitCntByDate, fetchCommitCntByUser, fetchPrCntByUser}
