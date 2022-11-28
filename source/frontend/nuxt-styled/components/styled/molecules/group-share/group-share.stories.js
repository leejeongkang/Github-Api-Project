import GroupShare from "./group-share.vue";

export default {
  title: 'Styled/Molecules/[PCFI] 공유하기',
  components: GroupShare,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 공유하기 </h2><story /></div>',
    }),
  ],
};

export const Default = () => ({
  components: { GroupShare },
  template: "<GroupShare></GroupShare>",
});
