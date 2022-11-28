import GroupFormboxVertical from '../group-formbox-vertical/group-formbox-vertical.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 테이블 - 세로형',
  components: GroupFormboxVertical,
  decorators: [() => ({template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 폼 테이블 그룹 - 세로형</h2><story /></div>'})],
};

export const Default = () => ({
  components: {GroupFormboxVertical},
  template: '<GroupFormboxVertical></GroupFormboxVertical>',
  methods: {}
});
