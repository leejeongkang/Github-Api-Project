import GroupDetailFilter from './group-detail-filter.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 상세 필터',
  components: GroupDetailFilter,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 상세 필터 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupDetailFilter },
  template: '<GroupDetailFilter></GroupDetailFilter>'
});
