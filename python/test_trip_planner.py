import unittest

from python.trip_planner import LifeSupportPlanner


class LifeSupportPlannerTest(unittest.TestCase):
    def test_1(self):
        crew = [
            {"food": 5, "water": 2, "oxygen": 10},
            {"food": 6, "water": 3, "oxygen": 10},
            {"food": 2, "water": 1, "oxygen": 10}
        ]
        res = [
            {"food": 6, "water": 2, "weight": 4},
            {"food": 8, "weight": 3},
            {"food": 8, "weight": 2},
            {"food": 2, "weight": 0.5},
            {"water": 2, "weight": 1},
            {"water": 3, "weight": 2},
            {"water": 4, "weight": 3},
            {"water": 5, "weight": 4},
            {"oxygen": 10, "weight": 2},
            {"oxygen": 10, "weight": 4},
            {"oxygen": 10, "weight": 3},
        ]

        planner = LifeSupportPlanner()
        items = planner.trip(items=res, crew_members=crew)
        self.assertEquals(sum((i["weight"] for i in items)), 21.5)
