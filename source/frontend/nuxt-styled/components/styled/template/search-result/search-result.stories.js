import Vuex from "vuex";

import SearchResult from "./search-result.vue";

export default {
  title: 'Styled/Templates/[PCFI] 한자연 검색 결과',
  components: { SearchResult },
};


export const Default = () => ({
  components: { SearchResult },
  template: '<SearchResult></SearchResult>',
});

export const CardType = () => ({
  components: { SearchResult },
  template: "<SearchResult listClass=\"data-box-list--card\"></SearchResult>",
});
