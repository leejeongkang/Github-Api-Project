import GroupSnb from "./group-snb.vue";

export default {
  title: 'Styled/Molecules/[PCFI] 사이드네비게이션',
  components: GroupSnb,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) SNB </h2><story /></div>',
    }),
  ],
};

export const Default = () => ({
  components: { GroupSnb },
  template: "<GroupSnb style=\"width: 220px;\"></GroupSnb>",
});
