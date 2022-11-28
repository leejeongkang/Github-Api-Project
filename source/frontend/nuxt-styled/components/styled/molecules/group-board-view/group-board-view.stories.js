import GroupBoardView from './group-board-view.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 게시판 - 보기',
  components: GroupBoardView,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 게시판 - 보기 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupBoardView },
  template: '<GroupBoardView></GroupBoardView>'
});
