import SearchFilterGroup from "./search-filter-group.vue";

export default {
  title: 'Styled/Organisms/[PCFI] 검색 필터 그룹',
  component: SearchFilterGroup,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 검색 필터 그룹 </h2><story /></div>' })],
};

// main-contents__search-filter 클래스는 하위 사이즈 조절을 위한 샘플 클래스로 작업 시 제거 필요
export const Default = () => ({
  components: { SearchFilterGroup },
  template: '<SearchFilterGroup class="search-filter-group--horizontal main-contents__search-filter"></SearchFilterGroup>'
});


export const VerticalDirection = () => ({
  components: { SearchFilterGroup },
  template: '<SearchFilterGroup class="search-filter-group--vertical"></SearchFilterGroup>'
});
