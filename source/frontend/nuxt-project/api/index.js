import axios from 'axios'

const instance = axios.create({
  baseURL: 'http://localhost:80/repo-api/'
})

function fetchRepos() {
  return instance.get('repos')
}

export { fetchRepos }
