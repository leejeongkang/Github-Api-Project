import GroupFileAttachResult from './group-file-attach-result.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 첨부 파일 목록',
  components: GroupFileAttachResult,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 첨부 파일 목록 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupFileAttachResult },
  template: '<GroupFileAttachResult></GroupFileAttachResult>'
});
