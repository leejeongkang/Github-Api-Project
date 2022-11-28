import GroupSearchFilter from './group-search-filter.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 검색 상세 필터',
  components: GroupSearchFilter,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 검색 상세 필터 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupSearchFilter },
  template: '<GroupSearchFilter></GroupSearchFilter>'
});
