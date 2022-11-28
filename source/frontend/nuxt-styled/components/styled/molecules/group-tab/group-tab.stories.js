import GroupTab from './group-tab.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 탭',
  components: GroupTab,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 탭 유형 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupTab },
  template: '<GroupTab></GroupTab>'
});
