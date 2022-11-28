import GroupButton from "./group-button.vue";

export default {
  title: 'Styled/Molecules/[PCFI] 버튼 그룹',
  components: GroupButton,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 버튼 그룹 </h2><story /></div>',
    }),
  ],
};

export const Default = () => ({
  components: { GroupButton },
  template: "<GroupButton></GroupButton>",
});
