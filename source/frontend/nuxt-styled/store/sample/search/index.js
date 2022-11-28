export const state = () => ({
  _tabs: [],
  _contents: [],
  _selectedTab: []
});

export const getters = {
  tabs(state) {
    return state._tabs;
  },
  contents(state) {
    return state._contents;
  },
  selectedTab(state) {
    return state._selectedTab;
  }
}

export const mutations = {
  setTabs(state, data) {
    state._tabs = data;
  },
  setContents(state, data) {
    state._contents = data;
  },
  setSelectedTab(state, data) {
    state._tabs.forEach(function (element) {
      element.selected = false;
      if (element.type == data) {
        element.selected = true;
        state._selectedTab = element;
      }
    })
  }
}

import sampleTabs from "./_tabs.json"
import sampleContents from "./_contents.json"

export const actions = {
  getTabs({ state, commit }) {
    commit("setTabs", sampleTabs);
    commit("setSelectedTab", sampleTabs[0].type);
  },
  getContents({ state, commit }) {
    commit("setContents", sampleContents);
  },
}
