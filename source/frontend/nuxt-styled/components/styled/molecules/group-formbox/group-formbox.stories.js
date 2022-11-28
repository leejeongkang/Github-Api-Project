
import GroupFormbox from './group-formbox.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 테이블 - 가로형',
  components: GroupFormbox,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 폼 테이블 그룹 - 가로형</h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupFormbox },
  template: '<GroupFormbox></GroupFormbox>',
  methods: {}
});
