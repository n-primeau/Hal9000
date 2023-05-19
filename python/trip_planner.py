

class LifeSupportPlanner:
    def trip(self, items, crew_members):
        resources_required = []
        [print("Crew Member", c) for c in crew_members]
        for i in items:
            for c in crew_members:
                for n in ("water", "food", "oxygen"):
                    if n in c and c.get(n) <= i.get(n, 0) and i not in resources_required:
                        resources_required.append(i)
                        c.pop(n)

        for i in crew_members:
            if i.get("water") or i.get("oxygen") or i.get("food"):
                raise RuntimeError("Not enough resources")

        print(resources_required)
        return resources_required
