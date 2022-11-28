import SearchList from "./search-list.vue";
import { action } from "@storybook/addon-actions";

export default {
  title: 'Styled/Organisms/[PCFI] 검색 리스트',
  component: SearchList,
};

export const Default = () => ({
  components: { SearchList },
  template: '<SearchList ></SearchList>',
});

export const ListType = () => ({
  components: { SearchList },
  template: "<SearchList class='data-box-list--card'></SearchList>",
});
