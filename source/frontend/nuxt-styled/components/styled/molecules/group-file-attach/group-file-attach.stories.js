import GroupFileAttach from './group-file-attach.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 파일 첨부',
  components: GroupFileAttach,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 파일 첨부 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupFileAttach },
  template: '<GroupFileAttach></GroupFileAttach>'
});
