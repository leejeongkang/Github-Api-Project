import GroupPagination from "./group-pagination.vue";

export default {
  title: 'Styled/Molecules/[PCFI] 페이지네이션',
  components: GroupPagination,
  decorators: [
    () => ({
      template:
        '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 페이지네이션 </h2><story /></div>',
    }),
  ],
};

export const Default = () => ({
  components: { GroupPagination },
  template: "<GroupPagination></GroupPagination>",
});
