import ListCard from "./list-card.vue";

export default {
  title: 'Styled/Organisms/[PCFI] 카드 리스트',
  component: ListCard,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 데이터 활용 사례 - 카드 리스트 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { ListCard },
  template: '<ListCard></ListCard>'
});
