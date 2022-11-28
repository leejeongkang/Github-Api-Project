import GroupCard from './group-card.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 카드',
  components: GroupCard,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 데이터 활용 사례 - 카드형 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupCard },
  template: '<GroupCard></GroupCard>'
});
