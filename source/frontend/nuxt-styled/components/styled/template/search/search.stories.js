import Vuex from "vuex";

import Search from "./search.vue";

export default {
  title: 'Styled/Templates/[PCFI] LH 검색 결과',
};

const Template = () => ({
  components: { Search },
  template: "<Search />",
});

export const Default = Template.bind({});
