export const state = () => ({
  _contents: []
});

export const getters = {
  contents(state) {
    return state._contents;
  }
};

export const mutations = {
  setContents(state, data) {
    state._contents = data;
  }
};

import sampleContents from "./_contents.json";

export const actions = {
  getContents({ state, commit }) {
    commit("setContents", sampleContents);
  }
};
